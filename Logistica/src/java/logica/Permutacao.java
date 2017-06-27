/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matheus
 */
public class Permutacao {
    
    public static List<List<Cordenadas>> listPermutations(List<Cordenadas> list) {

    if (list.size() == 0) {
        List<List<Cordenadas>> result = new ArrayList<List<Cordenadas>>();
        result.add(new ArrayList<Cordenadas>());
        return result;
    }

    List<List<Cordenadas>> returnMe = new ArrayList<List<Cordenadas>>();

    Cordenadas firstElement = list.remove(0);

    List<List<Cordenadas>> recursiveReturn = listPermutations(list);
    for (List<Cordenadas> li : recursiveReturn) {

        for (int index = 0; index <= li.size(); index++) {
            List<Cordenadas> temp = new ArrayList<Cordenadas>(li);
            temp.add(index, firstElement);
            returnMe.add(temp);
        }

    }
    return returnMe;
}
}
