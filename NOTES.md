- We can generate a list of `Question`s
  - This is all of the questions that are available.
  - Some of them have been asked and are in buckets,
    some are not.
- We persist the `WorkingSet`
- - a map of question `Id`s to their `QuestionInfo`

To generate the current list of questions:
1. Generate the Questions
2. Load the WorkingSet
3. Take the intersection of both sets of Ids
4. Count the number of level 1 questions, and if there are fewer than
   `threshold`, add new questions to get to that number.
5. For all of those, find the Ids that are after their 'next ask time'
   (or that are brand new).


