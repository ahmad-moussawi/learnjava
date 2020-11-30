#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#define PI 3.14

typedef struct {
    float Xr;
    float Xi;
} complex;

void graph(float tab[], int N)
{
    int scale = 30;
    int step = 7;
    for (int i = 0; i < N; i = i + step)
    {
        char r[(int)tab[i] * scale];

        strcpy(r, "-");

        for(int j = 0; j < (tab[i] * scale); j++)
        {
            strcat(r, "-");
        }

        printf("f(x%3d). %s (%f)\n", i, r, (float) tab[i]);
    }
}

float module (complex c)
{
    return sqrt(c.Xr * c.Xr + c.Xi * c.Xi);
}

// Σ()
float reelle(float tab[], int k, int N)
{
    float somme = 0;

    for(int i = 0; i < N; i++)
    {
        somme += tab[i] * cos(2 * PI * i * ((float)k / N));
    }

    return somme;
}


float imaginaire(float tab[], int k, int N)
{
    float somme = 0;

    for(int i = 0; i < N; i++)
    {
        somme += tab[i] * sin(2 * PI * i * ((float)k / N));
    }

    return -somme;
}

int main (int argc , char* argv[])
{
    int index, N;

    sscanf(argv[2], "%d", &N);

    float tab[N];


    float tfd_tab[N]; // temporaire pour le graph

    float val;


    FILE *signal = fopen(argv[1], "r");

    for(int n = 0; n < N; n++)
    {
        fscanf(signal, "%d %f", &index, &val);
        //printf("%d, %f\n", index, val);

        tab[n] = val;
    }
    fclose(signal);

    FILE *tfd = fopen("tfd.dat", "w");

    for(int k = 0; k < N; k++)
    {
        complex c;
        c.Xr = reelle(tab, k, N);
        c.Xi = imaginaire(tab, k, N);
        float mod = module(c);
        tfd_tab[k] = mod;

        //printf("k: %d, r: %f, i: %f, mod: %f\n", k, c.Xr, c.Xi, mod);
        fprintf(tfd, "%d\t%f\n", k, mod);
    }
    fclose(tfd);

    graph(tfd_tab, N);

}