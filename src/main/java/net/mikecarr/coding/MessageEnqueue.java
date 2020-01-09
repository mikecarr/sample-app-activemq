package net.mikecarr.coding;

import org.apache.camel.builder.RouteBuilder;
import org.apache.cxf.Bus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.xml.transform.Transformer;

@Component
public class MessageEnqueue extends RouteBuilder {

    public static final String routeId = "SENDCLICKSAPWORKTASKDETAILSERVICE_ENQUEUE";


    @Autowired
    private Bus bus;

    @Value("${route.enqueue.fromUri}")
    String enqueueFromUri;


    @Override
    public void configure() throws Exception {

        from(enqueueFromUri)
        .to("log:debug");
    }
}