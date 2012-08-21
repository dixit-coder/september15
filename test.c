#include <stdio.h>
 
int get_index(int idx, int N) {
    return (idx % 3) * N + (idx / 3);
}
 
void swap(int *a,int *b)
{
        int t=*a;
        *a=*b;
        *b=t;
}
 
void transform_array2(int *s, int len) {
    int N = len / 3,i;
    for(i = 0; i < len; i++) {
        int new_idx = get_index(i, N);
        while(new_idx < i) {
            new_idx = get_index(new_idx, N);
        }
        printf("i: %d; new_idx: %d\n", i, new_idx);
        swap(&s[i], &s[new_idx]);
    }
    for(i = 0; i < len; i++) {
        printf("%d ", s[i]);
    }
    printf("\n");
}
 
int main()
{
        int arr[]={12,11,10,9,8,7,1,2,3,4,5,6};
        transform_array2(arr,12);
        return 0;
}

