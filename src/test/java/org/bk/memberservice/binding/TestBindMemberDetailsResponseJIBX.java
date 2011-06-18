package org.bk.memberservice.binding;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.InputStream;
import java.io.StringWriter;

import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.bk.memberservice.message.MemberDetailsResponse;
import org.bk.memberservice.types.MemberDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(inheritLocations = true, locations = { "classpath:/META-INF/spring/applicationContext-oxm.xml" })
public class TestBindMemberDetailsResponseJIBX {
	@Autowired
	@Qualifier("jibxMarshaller")
	Marshaller marshaller;

	@Autowired
	@Qualifier("jibxUnMarshaller")
	Unmarshaller unmarshaller;

	@Test
	public void testUnMarshallingToMemberDetailsResponse() throws Exception {
		InputStream stream = this.getClass().getClassLoader()
				.getResourceAsStream("sampleMemberResponse.xml");
		Object memberDetailsRequestObj = unmarshaller
				.unmarshal(new StreamSource(stream));
		assertNotNull(memberDetailsRequestObj);
	}

	@Test
	public void testMarshallingToMemberDetailsResponse() throws Exception {
		MemberDetail memberDetail = new MemberDetail("testname", "testphone",
				"testcity", "teststate");
		MemberDetailsResponse response = new MemberDetailsResponse(memberDetail);
		StringWriter writer = new StringWriter();
		Result result = new StreamResult(writer);
		marshaller.marshal(response, result);
		assertNotNull(writer.toString());
		System.out.println(writer.toString());
		assertTrue(writer.toString().contains("memberdetail"));
	}

}
