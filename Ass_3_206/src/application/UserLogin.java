package application;

import java.io.IOException;

public class UserLogin {
	
	public static void startUp() {
		try {
			StorageAndSetUps.getInstance().ulc.passwordInput.setVisible(false);
			StorageAndSetUps.getInstance().ulc.userList.setVisible(false);
			StorageAndSetUps.getInstance().ulc.loginConfirm.setVisible(false);
			StorageAndSetUps.getInstance().ulc.goBack.setVisible(false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}


