package demo.app.applicationimpl;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import javax.validation.ConstraintValidator;
import javax.validation.Valid;

import org.hibernate.validator.constraints.SafeHtml;
import org.hibernate.validator.internal.constraintvalidators.hv.SafeHtmlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.app.application.DemoService;
import demo.app.dto.DemoDto;

@Service("demoService")
public class DemoServiceImpl implements DemoService {
	
	@Override
	public DemoDto create(DemoDto demoDto) {
		SafeHtmlValidator safeHtmlValidator = new SafeHtmlValidator();

		System.out.println(String.format("parameters %s", demoDto));
		return demoDto;
	}
	
	@Override
	public DemoDto createWithoutValid(DemoDto demoDto) {
		System.out.println(String.format("parameters %s", demoDto));
		return demoDto;
	}
	
	
	private static boolean validate(DemoDto demoDto) throws IllegalArgumentException, IllegalAccessException {
		Class cls = demoDto.getClass();
		for(Field field : cls.getDeclaredFields()){
			  Class type = field.getType();
			  String name = field.getName();
//			  Annotation[] annotations = field.getDeclaredAnnotations();
//			  for(Annotation annotation : annotations) {
//				  if(annotation.getClass().getTypeName().equals(SafeHtml.class.getName())) {
//					  System.out.println(String.format("field %s has safthtml", field.getName()));
//				  }
//			  }
			  if(field.isAnnotationPresent(SafeHtml.class)) {
				  SafeHtml safeHtmlAnnotation = field.getAnnotation(SafeHtml.class);
				  ConstraintValidator constraintValidator = new SafeHtmlValidator();
				  constraintValidator.initialize(safeHtmlAnnotation);
				  field.setAccessible(true);
				  boolean isValidate = constraintValidator.isValid(field.get(demoDto),null);
				  if(!isValidate) {
					  return false;
				  }
			  }
			}
		return true;
	}

	
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		DemoDto demoDto = new DemoDto();
		demoDto.setName("zhuqiang");
		demoDto.setAccount("<script>zhuqiang</script>");
		System.out.println(validate(demoDto));
	}
}
