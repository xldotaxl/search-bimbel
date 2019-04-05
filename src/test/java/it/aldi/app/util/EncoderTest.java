package it.aldi.app.util;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncoderTest {

  @Test
  public void encodeTest() {
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    String encodedPass = bCryptPasswordEncoder.encode("jurnal123");
    System.out.println(encodedPass);
  }
}
