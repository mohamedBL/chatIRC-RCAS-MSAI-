package com.cfranc.irc.ui;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

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
	
	public static void generationIcone(StyledDocument doc, int start,
			String text, String emo)
			throws BadLocationException {
		int i=text.indexOf(emo);
		while(i>=0) {
		    final SimpleAttributeSet attrs=new SimpleAttributeSet(doc.getCharacterElement(start+i).getAttributes());
		    if (StyleConstants.getIcon(attrs)==null) {
		    	StyleConstants.setIcon(attrs, Messages.selectionIcon(emo));
		        doc.remove(start+i, 2);
		        doc.insertString(start+i,emo, attrs);
		    }
		    i=text.indexOf(emo, i+2);
		 }
	}
	
	public static Icon selectionIcon(String emo) {
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

