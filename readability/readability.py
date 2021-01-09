from math import ceil

numberOfWords = 1
numberOfLetters = 0
numberOfSentences = 0

text = input('Text: ')

for c in text:
    if (c.isalpha()):
        numberOfLetters += 1

    elif c.isspace():
        numberOfWords += 1

    elif c == '.' or c == '?' or c == '!':
        numberOfSentences += 1

    if numberOfWords == 100:
        break

if numberOfWords < 100:
    numberOfLetters = (numberOfLetters / numberOfWords) * 100
    numberOfSentences = (numberOfSentences / numberOfWords) * 100

index = ceil((0.0558 * numberOfLetters) - (0.296 * numberOfSentences) - 15.8)

if index < 1:
    print('Before Grade 1')

elif index > 16:
    print('Grade 16+')

else:
    print(f'Grade {index}')
