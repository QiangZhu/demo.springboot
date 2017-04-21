# SpringBoot RabbitMQ demo

## Env

	OS : window10 home
	JDK : 1.8.0_121
	IDE : 3.8.3.RELEASE
	VirtualBox : 5.1.18 r114002 (Qt5.6.2)
	CentOS : CentOS-7-x86_64-Everything-1511
	docker : Docker version 17.04.0-ce, build 4845c56
	RabbitMQ : RabbitMQ 3.6.9
	Erlang : 19.3
	
## Install RabbitMQ docker img

	sudo docker run -d --hostname rabbit1 --name rabbit1 -e RABBITMQ_ERLANG_COOKIE='rabbitcluster' -p 30000:5672 -p 30001:15672 rabbitmq:managementfd
	sudo docker run -d --hostname rabbit2 --name rabbit2 --link rabbit1:rabbit1 -e RABBITMQ_ERLANG_COOKIE='rabbitcluster' -p 30002:5672 -p 30003:15672 rabbitmq:management
	sudo docker run -d --hostname rabbit3 --name rabbit3 --link rabbit1:rabbit1 --link rabbit2:rabbit2 -e RABBITMQ_ERLANG_COOKIE='rabbitcluster' -p 30004:5672 -p 30005:15672 rabbitmq:management

	su -
	
	service docker start
	
	docker start rabbit1
	docker start rabbit2 
	docker start rabbit3
	
	docker exec -i -t rabbit2 \bash
	root@rabbit2:/# rabbitmqctl stop_app
	root@rabbit2:/# rabbitmqctl join_cluster rabbit@rabbit1
	root@rabbit2:/# rabbitmqctl start_app
	
	docker exec -i -t rabbit3 \bash
	root@rabbit3:/# rabbitmqctl stop_app
	root@rabbit3:/# rabbitmqctl join_cluster rabbit@rabbit1
	root@rabbit3:/# rabbitmqctl start_app
	
	rabbitmqctl set_policy ha-all "" '{"ha-mode":"all","ha-sync-mode":"automatic"}'
	
	sudo docker stop rabbit3
	sudo docker stop rabbit2
	sudo docker stop rabbit1
	
	http://192.168.153.27:30001   guest/guest
	http://192.168.153.27:30003   guest/guest
	http://192.168.153.27:30005   guest/guest
	
## Reference
[rabbitmq-in-cluster]( https://dzone.com/articles/rabbitmq-in-cluster)
