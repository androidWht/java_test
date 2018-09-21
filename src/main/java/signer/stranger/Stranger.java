package signer.stranger;

import java.security.AccessController;
import java.security.PrivilegedAction;

import signer.doer.Doer;

public class Stranger implements Doer{
	
	private Doer next;
	private boolean direct;
	
	public Stranger(Doer next,boolean direct){
		this.next = next;
		this.direct = direct;
	}
	
	@Override
	public void doYourThings() {
		if(direct){
			next.doYourThings();
		}else{
			AccessController.doPrivileged(new PrivilegedAction<Object>() {

				@Override
				public Object run() {
					next.doYourThings();
					return null;
				}
				
			});
		}
	}
}
