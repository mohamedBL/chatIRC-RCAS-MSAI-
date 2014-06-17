package com.cfranc.irc.ui;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Messages {
	private static final String BUNDLE_NAME = "com.cfranc.irc.ui.messages"; //$NON-NLS-1$

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle
			.getBundle(BUNDLE_NAME);

	private Messages() {
	}

	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
	
	
	
	public static Icon insertionIcon(String emo) {
		String retour="";
		
		if (emo.equals(":)")) {
			retour = ".//resources//images//content.gif";
		}else
		if (emo.equals(":(")) {
			retour = ".//resources//images//colere.gif";
		}else
		if (emo.equals(";)")) {
			retour = ".//resources//images//surpris.gif";
		}
		Icon retour1 = new ImageIcon(retour);
		return retour1;
	}
		}

