package acme.testing.anonymous.duty;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmeEndeavoursTest;

public class AnonymousDutyListTest extends AcmeEndeavoursTest{

	@ParameterizedTest
	@CsvFileSource(resources = "/anonymous/duty/list.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void ListRecent(final int recordIndex, final String title, final String initialPeriod, final String finalPeriod, final String description) {

		super.clickOnMenu("Anonymous", "List non finished duties");

		super.checkColumnHasValue(recordIndex, 0, title);
		super.checkColumnHasValue(recordIndex, 1, initialPeriod);
		super.checkColumnHasValue(recordIndex, 2, finalPeriod);
		super.checkColumnHasValue(recordIndex, 3, description);

	}


	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/dashboard/dashboard-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void listAnonymousNegative(final String user, final String password) {

		super.signIn(user, password);

		this.driver.get("localhost:8080/Acme-Planner/anonymous/duty/list");
		super.checkNotPanicExists();

		super.signOut();
	}
}
