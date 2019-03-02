package home.stanislavpoliakov.meet20_practice;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        MainActivityExistTest.class,
        PeopleActivityExistTest.class,
        InfoFragmentExistTest.class,
        UseCaseTests.class
})
public class TestSuite {
}
