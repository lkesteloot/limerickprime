# Limerick prime

Finds prime numbers that are also limericks. Inspired by the
post [Limerick primes](http://www.johndcook.com/blog/2011/03/08/limerick-primes/)
by John D. Cook, although he's looking for a smaller, simpler pattern, like
11551. This code looks for a prime number that, when read aloud, works like
a limerick. For example:

    23444683
    93324223
    96296
    98326
    46359543

The pattern of syllables looks like this, with * being the emphasized ones.

    1*11*11*
    1*11*11*
    1*11*
    1*11*
    1*11*11*

Constraints:

* Digits with one syllable: one, two, three, four, five, six, eight, nine.
* Digits with two syllables: zero, seven.
* The zero and seven replace two digits and can only appear in position 2 (any line) or
  5 (lines 1, 2, or 5).
* Lines 1, 2, and 5 must rhyme.
* Lines 3 and 4 must rhyme.
* None of the digits rhyme with each other, so can only rhyme with themselves.

We can simplify by skipping zero and seven so that we have a consistent number
of digits. The pattern for the last digit is:

    1*11*11x
    1*11*11x
    1*11y
    1*11y
    1*11*11x

* x can't be 0, 2, 4, 6, 8, or 5 (not prime) or 7 (two syllables). Must be one of: 1, 3, 9.
* y can't be 0 or 7 (two syllables). Must be one of: 1, 2, 3, 4, 5, 6, 8, 9.
* That's 3×8 = 24 possibilities.
* If using only one-syllable digits, there are 7×3 + 4×2 = 29 remaining digits, each
  can be 8 values, so that's 8^29 possibilities.
* Altogether there are 8×3 + 5×2 = 34 digits in the number.

The `LimerickPrime.java` program generates a random 34-digit number and then
tries all the values for x and y. Run with:

    % ./GO

# License

Copyright 2015 Lawrence Kesteloot

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
