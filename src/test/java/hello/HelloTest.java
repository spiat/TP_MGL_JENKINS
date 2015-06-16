package hello;

import org.junit.Test;
import org.junit.Before;

import static org.assertj.core.api.Assertions.*;

public class HelloTest {

  Hello hello;

  @Before
  public void setup() {
    hello = new Hello();
  }

  @Test
  public void check() {
    assertThat(hello.hello("Julien"))
      .isNotEmpty()
      .contains("Hello")
      .endsWith("!")
      .isEqualTo("Hello Julien!");
    /*assertThat(hello.hello("Sol le gros tas"))
      .isNotEmpty()
      .contains("Hello")
      .endsWith("!")
      .isEqualTo("Sof <3");*/
  }

  @Test
  public void check_null() {
    assertThatThrownBy(() -> hello.hello(null))
      .isInstanceOf(IllegalArgumentException.class)
      .hasMessageContaining("cannot be null");
  }
}
