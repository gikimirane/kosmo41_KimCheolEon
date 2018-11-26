package com.study.spring;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.io.*;

public class SHA256 {

	public String getSHA256(String input) {

		String toReturn = null;
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			digest.reset();
			digest.update(input.getBytes("utf8"));
			toReturn = String.format("%040x", new BigInteger(1, digest.digest()));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return toReturn;
	}

}
