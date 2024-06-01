package com.example.demo;

import com.example.demo.controller.EventController;
import com.example.demo.entity.EventEntity;
import com.example.demo.service.IEventService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.Assert;

import static org.mockito.Mockito.when;

@SpringBootTest
class DemoApplicationTests {

	@Mock
	IEventService eventService;

	@MockBean
	EventController eventController;

	@Test
	void testAddEvent(){
		EventEntity event = EventEntity.builder()
				.eventDate("test")
				.eventName("test")
				.eventLocation("test")
				.build();

		when(eventService.saveEvent(event)).thenReturn(event);

		EventEntity eventResponse = eventController.saveEvent(event).getBody();

		Assertions.assertEquals(event,eventResponse);

	}

}
