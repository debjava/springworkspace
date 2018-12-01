package com.ddlab.rnd;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;

public class CreditCard implements BeanNameAware , BeanFactoryAware , ICard {

	public String getType() {
		return "CreditCard";
	}

	public void setBeanName( String beanId ) {
		//Part of BeanNameAware
		System.out.println("Defined Bean Id :::"+beanId);
	}

	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		//Part of BeanFactoryAware
		System.out.println("Bean Factory :::"+beanFactory);
	}
	
}
