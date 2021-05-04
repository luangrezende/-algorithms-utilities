using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace TesteFuncoes.Models
{
    public class Metodos
    {
        //BUBBLE SORT RAIZ
        public List<int> OrdenaNumeros(List<int> numeros)
        {
            int temp = 0;

            for (int write = 0; write < numeros.ToArray().Length; write++)
            {
                for (int sort = 0; sort < numeros.ToArray().Length - 1; sort++)
                {
                    if (numeros[sort] > numeros[sort + 1])
                    {
                        temp = numeros[sort + 1];
                        numeros[sort + 1] = numeros[sort];
                        numeros[sort] = temp;
                    }
                }
            }
            return numeros;
        }

        //GET MENOR NUMERO
        public int MenorNumero(bool escolha, List<int> numeros)
        {
            switch (escolha)
            {
                //METODO NUTELLA
                case true:
                    numeros.Sort(); //ordena numeros

                    foreach (var item in numeros)
                    {
                        return item;
                    }
                    return 0; //gambiarra

                //METODO RAIZ
                case false:
                    int temp = 0;

                    for (int write = 0; write < numeros.ToArray().Length; write++)
                    {
                        for (int sort = 0; sort < numeros.ToArray().Length - 1; sort++)
                        {
                            if (numeros[sort] > numeros[sort + 1])
                            {
                                temp = numeros[sort + 1];
                                numeros[sort + 1] = numeros[sort];
                                numeros[sort] = temp;
                            }
                        }
                    }
                    return numeros[0];
            }
            return 0;
        }








    }
}