package delegate;

import Transport.ITransport;

public abstract class TransportDelegate {
	abstract public void invoke(ITransport transport);
}
