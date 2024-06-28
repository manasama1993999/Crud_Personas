package models.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validaciones {

	public boolean validarRut(String rut){
        try
        {
            String[] rut_dv = rut.split("-");
            if (rut_dv.length == 2)
            {
                int rutValor = Integer.parseInt(rut_dv[0]);
                String DV = rut_dv[1].substring(0).toUpperCase();
                char dv = DV.charAt(0);

                // Validamos que sea un rut valido según la norma
                int m = 0, s = 1;
                for (; rutValor != 0; rutValor /= 10)
                {
                    s = (s + rutValor % 10 * (9 - m++ % 6)) % 11;
                }

                return dv == (char) (s != 0 ? s + 47 : 75);
            }
            return false;
        }
        catch(NumberFormatException e)
        {
            return false;
        }
    }


    public boolean validarEmail(String email){
        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }


}

