/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Test;

import helper.DokterHelper;
import helper.KlinikHelper;
import helper.LocationHelper;
import helper.PasienHelper;

/**
 *
 * @author admin
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(KlinikHelper.toJson());
        System.out.println("");
        System.out.println(DokterHelper.toJson());
    }
}