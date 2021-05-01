package com.capuani.crippy.test;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    public Test[] getTest () {

        return new Test[] {new Test(11, "test", 14), new Test(11, "test", 14)};

    }

}
