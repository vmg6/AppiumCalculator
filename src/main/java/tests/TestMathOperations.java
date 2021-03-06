package tests;

import static enums.MathOperations.MINUS;
import static enums.MathOperations.PLUS;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import core.TestBase;
import enums.MathOperations;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * Created by v.matviichenko
 */
@RunWith (Parameterized.class)
public class TestMathOperations extends TestBase {

	@Parameterized.Parameter()
	public int firstValue;

	@Parameterized.Parameter(1)
	public int secondValue;

	@Parameterized.Parameter(2)
	public int expectedResult;

	@Parameterized.Parameter(3)
	public MathOperations operation;


	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][]{
				{2, 3, 5, PLUS},
				{10, 2, 8, MINUS}};
		return Arrays.asList(data);
	}

    @Test
    public void testMathOperation(){
        pageObject.clickOnDigitButton(firstValue);
        pageObject.selectMathOperation(operation);
        pageObject.clickOnDigitButton(secondValue);
        pageObject.clickOnEqualButton();

        assertEquals("Base math operation is wrong", Integer.parseInt(pageObject.resultView().getText()), expectedResult);
    }
}
