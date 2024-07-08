# Soundex Search
The basis of phonetic spell-check algorithms lies in the phonetic representation of words. These algorithms aim to map words
with similar pronunciations or phonetic characteristics to the same or similar representations. By doing so, they enable the 
identification and correction of spelling mistakes based on their phonetic similarity rather than their exact textual form. 
But how is this achieved?

The crucial part of the entire process is to generate a phonetic hash of a word and then compare it with the rest of them.
While different algorithms produce varied hashes, Soundex, for instance, generates a four-letter code.

![Soundex search](./soundex-algorithm.webp)

## Time Complexity
O(n)

## Space Complexity
O(n)
