package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.worker;

public class PaymentCountdownThread extends Thread {

	private static final Integer milisecondsInASecond = 1000;

	
	@Override
	public void run() {
		try {
			//Integer secondsToSleep = turn.getStimatedTime();
			Integer milisecondsToSleep = 50 * milisecondsInASecond;
			Thread.sleep(milisecondsToSleep);
			//cartService.createCashRegisterPurchaseFor(turn);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
