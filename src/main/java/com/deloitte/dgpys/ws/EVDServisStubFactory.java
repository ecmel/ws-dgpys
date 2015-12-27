package com.deloitte.dgpys.ws;

import org.apache.axiom.om.OMNamespace;
import org.apache.axiom.soap.SOAPEnvelope;
import org.apache.axis2.AxisFault;
import org.apache.axis2.context.MessageContext;
import org.apache.axis2.context.ServiceContext;
import org.apache.axis2.description.MessageContextListener;

/**
 *
 * @author ecmel
 */
public final class EVDServisStubFactory {

  private EVDServisStubFactory()
  {
  }

  public static EVDServisStub newInstance() throws AxisFault
  {
    EVDServisStub stub = new EVDServisStub("https://dgpysws.epias.com.tr/dgpys/services/EVDServis");

    stub._getServiceClient().engageModule("addressing");
    stub._getServiceClient().getOptions().setManageSession(true);
    stub._getServiceClient().getAxisService().addMessageContextListener(new MessageContextListenerImpl());

    return stub;
  }

  private static final class MessageContextListenerImpl implements MessageContextListener {

    @Override
    public void attachServiceContextEvent(ServiceContext sc, MessageContext mc)
    {
    }

    @Override
    public void attachEnvelopeEvent(MessageContext mc)
    {
      if ("in".equals(mc.getAxisMessage().getDirection())) {
        SOAPEnvelope envelope = mc.getEnvelope();
        OMNamespace ns = envelope.declareNamespace("http://ws.dgpys.deloitte.com", "dgp");
        envelope.getBody().getFirstElement().setNamespace(ns);
        envelope.build();
      }
    }
  }
}
