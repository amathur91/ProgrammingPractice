package com.general.problems;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SufficientTeamTest {
    SufficientTeam sufficientTeam = new SufficientTeam();

    @Test
    public void test1(){
        String[] req_skills = {"java","nodejs","reactjs"};
        ArrayList<List<String>> peopleSkills = new ArrayList<>();
        peopleSkills.add(Arrays.asList("java"));
        peopleSkills.add(Arrays.asList("nodejs"));
        peopleSkills.add(Arrays.asList("nodejs","reactjs"));
        int[] results = sufficientTeam.smallestSufficientTeam(req_skills, peopleSkills);
        assert results[0] == 0;
        assert results[1] == 2;
    }

    @Test
    public void test2(){
        String[] req_skills = {"algorithms","math","java","reactjs","csharp","aws"};
        ArrayList<List<String>> peopleSkills = new ArrayList<>();
        peopleSkills.add(Arrays.asList("algorithms","math","java"));
        peopleSkills.add(Arrays.asList("algorithms","math","reactjs"));
        peopleSkills.add(Arrays.asList("java","csharp","aws"));
        peopleSkills.add(Arrays.asList("reactjs","csharp"));
        peopleSkills.add(Arrays.asList("csharp","math"));
        peopleSkills.add(Arrays.asList("aws","java"));
        int[] results = sufficientTeam.smallestSufficientTeam(req_skills, peopleSkills);
        assert results[0] == 1;
        assert results[1] == 2;
    }


}
