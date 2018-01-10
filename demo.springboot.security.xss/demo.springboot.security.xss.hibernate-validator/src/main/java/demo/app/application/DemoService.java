package demo.app.application;

import demo.app.dto.DemoDto;

public interface DemoService {

	DemoDto create(DemoDto demoDto);

	DemoDto createWithoutValid(DemoDto demoDto);

}
