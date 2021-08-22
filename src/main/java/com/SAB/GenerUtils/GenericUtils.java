package com.SAB.GenerUtils;

import java.util.List;

import org.openqa.selenium.WebElement;

public class GenericUtils {
	
	public WebElement handlelist(List<WebElement> wb, String name)
	{
		for(WebElement wc: wb)
		{
			if(wc.getText().equals(name))
			{
				return wc;
			}
		}
		return null;
	}

}
