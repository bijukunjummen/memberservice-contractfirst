package org.bk.memberservice.binding;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.bk.memberservice.message.MemberDetailsRequest;
import org.junit.Test;

public class TestJaxbRequestBinding {

	@Test
	public void testJaxbBinding() throws Exception{
		JAXBContext jaxbContext = JAXBContext.newInstance(MemberDetailsRequest.class);
		assertThat((jaxbContext instanceof org.eclipse.persistence.jaxb.JAXBContext), is(true));
		Marshaller marshaller = jaxbContext.createMarshaller();
		
		MemberDetailsRequest memberDetailsRequest = new MemberDetailsRequest();
		memberDetailsRequest.setId(1L);
		StringWriter writer = new StringWriter();
		
		marshaller.marshal(memberDetailsRequest, writer);
		String marshalledXml = writer.toString();
		assertThat(marshalledXml, containsString("MemberDetailsRequest"));
	}
}
