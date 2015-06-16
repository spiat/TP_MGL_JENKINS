package fr.insalyon.telecom.mgl.RomanNumberConverter;
import org.junit.Test;
import org.junit.Before;

import static org.assertj.core.api.Assertions.*;

public class RomanNumberConverterTest {

  RomanNumberConverter conv;

  @Before
  public void setup() {
    conv = new RomanNumberConverter();
  }

  @Test
  public void check_I() {
    assertThat(conv.convert("I")).isEqualTo(1);
   }
   @Test
  public void check_II() {
    assertThat(conv.convert("II")).isEqualTo(2);
   }
 
  @Test
  public void check_Ii() {
    assertThat(conv.convert("Ii")).isEqualTo(2);
   }
  
  @Test
  public void check_MMMMMDCXLIX() {
    assertThat(conv.convert("MMMMMDCXLIX")).isEqualTo(5649);
   }
   
  @Test
  public void check_XCIX() {
    assertThat(conv.convert("XCIX")).isEqualTo(99);
   }
   
      	@Test
  public void check_CI() {
    assertThat(conv.convert("CI")).isEqualTo(101);
   }
   
   	@Test
  public void check_IC() {
    assertThat(conv.convert("IC")).isEqualTo(99);
   }
   
	@Test
  public void check_1() {
    assertThat(conv.convert(1)).isEqualTo("I");
   }
   
   	@Test
  public void check_2() {
    assertThat(conv.convert(2)).isEqualTo("II");
   }
   
	@Test
  public void check_100() {
    assertThat(conv.convert(100)).isEqualTo("C");
   }
   
   	@Test
  public void check_1000() {
    assertThat(conv.convert(1000)).isEqualTo("M");
   }
   
     @Test
  public void check_555() {
    assertThat(conv.convert(555)).isEqualTo("DLV");
   }
   
   
  @Test
  public void check_666() {
    assertThat(conv.convert(666)).isEqualTo("DCLXVI");
   }
   
   
   
   
   
   
   
  @Test
  public void check_unreckognized() {
    assertThatThrownBy(() -> conv.convert("cimer")).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Number unreckognized");
   }

  @Test
  public void check_null() {
    assertThatThrownBy(() -> conv.convert(null))
      .isInstanceOf(IllegalArgumentException.class)
      .hasMessageContaining("cannot be null");
  }
}
