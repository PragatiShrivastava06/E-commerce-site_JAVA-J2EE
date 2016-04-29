package com.scu.test;

import com.scu.logic.BackendLogic;
import com.scu.transport.SearchTransport;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BackendLogic logic = new BackendLogic();
		SearchTransport searchTransport = new SearchTransport();
		logic.getProductList(searchTransport);
	}

}
