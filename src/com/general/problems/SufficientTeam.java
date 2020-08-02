package com.general.problems;

import java.util.*;
import java.util.stream.Collectors;

public class SufficientTeam {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        HashMap<String, List<Integer>> skillPeopleMap = new HashMap<>();
        buildSkillPeopleMap(people, skillPeopleMap);
        ArrayList<Integer> sufficientSkill = findSufficientSkill(skillPeopleMap, req_skills, people);
        int[] result = new int[sufficientSkill.size()];
        for(int index = 0; index < result.length; index++){
            result[index] = sufficientSkill.get(index);
        }
        return result;
    }

    private ArrayList<Integer> findSufficientSkill(HashMap<String, List<Integer>> skillToPeopleMap, String[] req_skills, List<List<String>> peopleSkills) {
        HashSet<String> remainingSkills = new HashSet<>();
        for(String skill : req_skills){
            remainingSkills.add(skill);
        }
        ArrayList<Integer> finalResult = new ArrayList<>();
        ArrayList<Integer> selectedPeople = new ArrayList<>();
        findPeopleWithSkills(req_skills, 0, remainingSkills, skillToPeopleMap, selectedPeople,peopleSkills, finalResult);
        return finalResult;
    }

    private void findPeopleWithSkills(String[] req_skills, int skillIndex, HashSet<String> remainingSkills, HashMap<String, List<Integer>> skillToPeopleMap,
                                      ArrayList<Integer> selectedPeople, List<List<String>> peopleSkills, ArrayList<Integer> finalResult) {
        System.out.println("skillIndex : " + skillIndex + " remaining Skills : "  + remainingSkills );

        if(skillIndex < req_skills.length && remainingSkills.size() > 0) {
            if (remainingSkills.contains(req_skills[skillIndex])) {
                List<Integer> peopleList = skillToPeopleMap.get(req_skills[skillIndex]);
                for (Integer peopleIndex : peopleList) {
                    if(!selectedPeople.contains(peopleIndex)) {
                        Set<String> skillsOfPersonSelected = remainingSkills.stream().distinct().filter(peopleSkills.get(peopleIndex)::contains).collect(Collectors.toSet());
                        selectedPeople.add(peopleIndex);
                        remainingSkills.removeAll(skillsOfPersonSelected);
                        findPeopleWithSkills(req_skills, skillIndex + 1, remainingSkills, skillToPeopleMap, selectedPeople, peopleSkills, finalResult);
                        selectedPeople.remove(selectedPeople.indexOf(peopleIndex));
                        remainingSkills.addAll(skillsOfPersonSelected);
                    }
                }
            } else {
                findPeopleWithSkills(req_skills, skillIndex + 1, remainingSkills, skillToPeopleMap, selectedPeople, peopleSkills, finalResult);
            }
        }else {
            if(remainingSkills.size() == 0) {
                if (finalResult.size() == 0) {
                    finalResult.addAll(selectedPeople);
                } else {
                    if (selectedPeople.size() < finalResult.size()) {
                        finalResult.clear();
                        finalResult.addAll(selectedPeople);
                    }
                }
            }
        }
    }

    private void buildSkillPeopleMap(List<List<String>> people, HashMap<String, List<Integer>> skillPeopleMap) {
        for (int peopleIndex = 0; peopleIndex < people.size(); peopleIndex++){
            for (String skill : people.get(peopleIndex)){
                if(skillPeopleMap.containsKey(skill)){
                    skillPeopleMap.get(skill).add(peopleIndex);
                }else{
                    ArrayList<Integer> peopleList = new ArrayList<>();
                    peopleList.add(peopleIndex);
                    skillPeopleMap.put(skill, peopleList);
                }
            }
        }
    }
}
