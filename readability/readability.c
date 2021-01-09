#import <stdio.h>
#import <ctype.h>
#import <cs50.h>
#import <string.h>
#import <math.h>

int main(void)
{
    float numberOfWords = 1;
    float numberOfLetters = 0;
    float numberOfSentences = 0;
    int index;

    string text = get_string("Text: ");

    for (int i = 0; i < strlen(text); i++)
    {
        if (isalpha(text[i]))
        {
            numberOfLetters++;
        }

        else if (isspace(text[i]))
        {
            numberOfWords++;
        }

        else if (text[i] == '.' || text[i] == '?' || text[i] == '!')
        {
            numberOfSentences++;
        }

        if (numberOfWords == 100)
        {
            break;
        }
    }

    if (numberOfWords < 100)
    {
        numberOfLetters = (numberOfLetters / numberOfWords) * 100;
        numberOfSentences = (numberOfSentences / numberOfWords) * 100;
    }

    index = round(0.0588 * numberOfLetters - 0.296 * numberOfSentences - 15.8);

    if (index < 1)
    {
        printf("Before Grade 1\n");
    }

    else if (index > 16)
    {
        printf("Grade 16+\n");
    }

    else
    {
        printf("Grade %i\n", index);
    }

}
