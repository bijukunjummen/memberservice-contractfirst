package org.bk.memberservice.binding;

import java.io.InputStream;
import java.io.StringWriter;

import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.bk.memberservice.message.MemberDetailsRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.xml.transform.StringSource;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(inheritLocations=true,  locations={"classpath:/applicationContext-memberservice.xml"})
public class TestBindMemberDetailsRequest {
	@Autowired
	@Qualifier("unmarshaller")
	Unmarshaller unmarshaller; 

	@Autowired
	@Qualifier("marshaller")
	Marshaller marshaller; 

	@Test
	public void testUnMarshallingToMemberDetailsRequest() throws Exception{
		InputStream stream = this.getClass().getClassLoader().getResourceAsStream("sampleMemberRequest.xml");
		Object memberDetailsRequestObj = unmarshaller.unmarshal(new StreamSource(stream));
		assertNotNull(memberDetailsRequestObj);
	}
	@Test
	public void testMarshallingToMemberDetailsRequest() throws Exception{
		MemberDetailsRequest memberDetailsRequest = new MemberDetailsRequest();
		memberDetailsRequest.setId("SAMPLE");
		StringWriter writer = new StringWriter();
		Result result = new StreamResult(writer);		
		marshaller.marshal(memberDetailsRequest, result);
		assertTrue(writer.toString().contains("MemberDetailsRequest"));
	}
	
	
	
}
