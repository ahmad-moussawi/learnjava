#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>
//#define NBR_VALEUR_MAX 131072

//#define TAILLE_DENSITE  50
//#define NMAX 8

/*main(int argc, char *argv[])
{
    float DENSITE[TAILLE_DENSITE];

}
*/



void graph(int tab[], int taille_densite, int nbr_valeur_max,int nmax)
{
    for (int i = 0; i < taille_densite; i++)
    {
        char r[tab[i]];

        strcpy(r, "-");

        for(int j = 0; j < (tab[i] * 500 * nmax / nbr_valeur_max); j++)
        {
            strcat(r, "-");
        }

        printf("f(x%3d). %s (%f)\n", i, r, (float) tab[i]* taille_densite/ nbr_valeur_max);
    }
}

float generate_random(int iteration)
{
    float somme = 0;

    for(int i = 0; i < iteration; i++)
    {
        somme += rand() / (float)RAND_MAX;
    }

    return somme/iteration;
}

int main (int argc,char* argv[])
{
    int NBR_VALEUR_MAX, NMAX, TAILLE_DENSITE, i = 0, imin, j;
    float X, somme = 0;

    sscanf(argv[2],"%d", &NBR_VALEUR_MAX);
    sscanf(argv[3],"%d", &NMAX);
    sscanf(argv[4],"%d", &TAILLE_DENSITE);

    float A[NBR_VALEUR_MAX];
    float valeur;

    int taille[TAILLE_DENSITE];

    for (i = 0; i < TAILLE_DENSITE; i++)
    {
        taille[i] = 0;
    }

    // 1. Generation des nobmres
    for (i = 0; i < NBR_VALEUR_MAX; i++)
    {
        A[i] = generate_random(NMAX);

        // valeur = A[i];
        int index = A[i] * TAILLE_DENSITE;
        taille[index]++;

    }



    /*------------------------------------------
    A      => 0 [               ----->            ] 1

                        x TAILLE_DENSITE

    TAILLE => 0 [  |  |  |  |  |  | ...           ] TAILLE_DENSITE
                  0  1  2  3  4  5 ...
    ------------------------------------------------ */

    /*
    1000 --> 100%
    250 ---> x?

              scale / akbar ra2em momken
    x = 250 x 100 / 1000

    */



    FILE *signal = fopen("densite.dat", "w");

    for (i=0; i < TAILLE_DENSITE; i++)
    {
        printf(
            "hhtaille[%2d]: %8d,\t P(%2d): %8f,\t F(%2d): %8f \n ",
            i, taille[i/100],
            i, (float) taille[i]/NBR_VALEUR_MAX,
            i, (float) (taille[i] * TAILLE_DENSITE) / NBR_VALEUR_MAX);

        fprintf(signal, "%f\n",(float) (taille[i] * TAILLE_DENSITE) / NBR_VALEUR_MAX);
    }
    fclose(signal);


    // graphe
    graph(taille, TAILLE_DENSITE, NBR_VALEUR_MAX, NMAX);
}