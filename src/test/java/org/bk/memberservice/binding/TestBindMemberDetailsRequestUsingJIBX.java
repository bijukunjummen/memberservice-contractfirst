package org.bk.memberservice.binding;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.InputStream;
import java.io.StringWriter;

import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.bk.memberservice.message.MemberDetailsRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(inheritLocations=true,  locations={"classpath:/META-INF/spring/applicationContext-oxm.xml"})
public class TestBindMemberDetailsRequestUsingJIBX {
	@Autowired
	@Qualifier("jibxUnMarshaller")
	Unmarshaller unmarshaller; 

	@Autowired
	@Qualifier("jibxMarshaller")
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
		memberDetailsRequest.setId(1L);
		StringWriter writer = new StringWriter();
		Result result = new StreamResult(writer);		
		marshaller.marshal(memberDetailsRequest, result);
		assertTrue(writer.toString().contains("MemberDetailsRequest"));
	}
	
	
	
}
