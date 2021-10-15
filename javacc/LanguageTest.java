package javacc;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.junit.jupiter.api.Test;


class LanguageTest {

	@Test
	void test1() throws ParseException{
		String input ="skip";
		InputStream inputStream = new ByteArrayInputStream(input.getBytes());
		boolean parsed=new javacc.Language(inputStream).parseCommand();
		assertTrue(parsed);

	}
	@Test
	void test2() throws ParseException{
		String input ="b:=7 a:=99";
		InputStream inputStream = new ByteArrayInputStream(input.getBytes());
		assertThrows(ParseException.class, () -> { new javacc.Language(inputStream).parseCommand();});

	}
	@Test
	void test3() throws ParseException {
		String input ="tt^5";
		InputStream inputStream = new ByteArrayInputStream(input.getBytes());
		assertThrows(ParseException.class, () -> { new javacc.Language(inputStream).parseCommand();});

	}
	@Test
	void test4() throws ParseException {
		String input ="a:=7 ; b:=6";
		InputStream inputStream = new ByteArrayInputStream(input.getBytes());
		boolean parsed=new javacc.Language(inputStream).parseCommand();
		assertTrue(parsed);
	}
	@Test
	void test5() throws ParseException {
		String input ="a:=7 ; b:=6";
		InputStream inputStream = new ByteArrayInputStream(input.getBytes());
		boolean parsed=new javacc.Language(inputStream).parseCommand();
		assertTrue(parsed);
	}
	@Test
	void test6() throws ParseException ,UnsupportedEncodingException{
		String input ="if ((a == 5) ^(b==9)) then skip else skip";
		InputStream inputStream = new ByteArrayInputStream(input.getBytes());
		boolean parsed=new javacc.Language(inputStream).parseCommand();
		assertTrue(parsed);
	}
	@Test
	void test7() throws ParseException,TokenMgrError{
		String input ="a:= ( aaa - bbb )";
		InputStream inputStream = new ByteArrayInputStream(input.getBytes());
		boolean parsed=new javacc.Language(inputStream).parseCommand();
		assertTrue(parsed);
	}
	@Test
	void test8() throws ParseException{
		String input ="while ( ( a == 99879 ) ^ ( abf ==90 ) ) do  a := 9 ; d := 897  ";
		InputStream inputStream = new ByteArrayInputStream(input.getBytes());
		boolean parsed=new javacc.Language(inputStream).parseCommand();
		assertTrue(parsed);
	}
	@Test
	void test9() throws ParseException {
		String input ="fff := 909";
		InputStream inputStream = new ByteArrayInputStream(input.getBytes());
		boolean parsed=new javacc.Language(inputStream).parseCommand();
		assertTrue(parsed);
	}
	@Test
	void test10() throws ParseException {
		String input ="a:=7 ; b:=6 ; if tt  then b := (a + b) else b := (b - 1 )";
		InputStream inputStream = new ByteArrayInputStream(input.getBytes());
		boolean parsed=new javacc.Language(inputStream).parseCommand();
		assertTrue(parsed);
	}
	@Test
	void test11() throws ParseException{
		String input ="while  ! ff  do  if ( add == 9890 ) then b := (a + b) else b := (b - 1 )";
		InputStream inputStream = new ByteArrayInputStream(input.getBytes());
		boolean parsed=new javacc.Language(inputStream).parseCommand();
		assertTrue(parsed);
	}
	@Test
	void test12() throws ParseException{
		String input ="a:=7 ; b:=6";
		InputStream inputStream = new ByteArrayInputStream(input.getBytes());
		boolean parsed=new javacc.Language(inputStream).parseCommand();
		assertTrue(parsed);
	}
	@Test
	void test13() throws ParseException {		String input ="skip ; if ( add == 9890 ) then while  tt  do e := d else b := (b - 1 )";
		InputStream inputStream = new ByteArrayInputStream(input.getBytes());
		boolean parsed=new javacc.Language(inputStream).parseCommand();
		assertTrue(parsed);
	}
	@Test
	void test14() throws ParseException {
		String input ="if fff a:=9 else skip";
		InputStream inputStream = new ByteArrayInputStream(input.getBytes());
		assertThrows(ParseException.class, () -> { new javacc.Language(inputStream).parseCommand();});
	}
	@Test
	void test15() throws ParseException {
		String input ="while ( a := 8 ) do b:=9";
		InputStream inputStream = new ByteArrayInputStream(input.getBytes());
		assertThrows(ParseException.class, () -> { new javacc.Language(inputStream).parseCommand();});
	
	}
}