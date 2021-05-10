package com.iscte.ProjetoES.CodeSmells;

import static org.junit.Assert.*;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SeletorCodeSmTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testMain() {
		SeletorCodeSm sm = new SeletorCodeSm();
		sm.main(null);
	}

	@Test
	public final void testSeletorCodeSm() {
		SeletorCodeSm sm = new SeletorCodeSm();
	}

	@Test
	public final void testDetetorLM() {
		SeletorCodeSm sm = new SeletorCodeSm();
		try {
			sm.detetorLM("o", "o", 1, 1, "o");
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public final void testDetetorGC() {
		SeletorCodeSm sm = new SeletorCodeSm();
		try {
			sm.detetorGC("a", "a", "a", 0, 0, "a");
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
