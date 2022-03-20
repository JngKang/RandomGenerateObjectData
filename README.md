## Function
Randomly generate data for arbitrary objects.
## Ideas
According to the class's bytecode file, set the random data of the object.
1. Get the default constructor of the class and create an empty object.
2. Get the properties of the class, then get the setter methods corresponding to the properties, and finally call the setter methods to assign values to the related properties.
## Technology stack
- Reflection
- Enumerate
- Annotation
## Types currently supported
  - ### Numeric type
      - BigDecimal
      - Integer
  - ### Date type
      - LocalData
      - LocalDataTime
  - ### String type
      - String
          - 1-Pure numbers
          - 2-Pure lowercase letters
          - 3-Pure uppercase letters
          - 4-Uppercase and lowercase letters
          - 5-Combination of uppercase and lowercase letters
          - 6-Chinese character string
          - 7-Chinese name
          - 8-Random mailbox
          - 9-Random phone number
## Usage of annotations
- min(): Minimum value
- max(): Maximum value
- type(): String type
- minLen(): Minimum String length
- maxLen(): Maximum String length
- bigMin(): BiaDecimal Minimum length
- bigMax(): BiaDecimal Maximum length
- precision(): Precision
- startDate(): Start Date
- endDate(): End Date
- startDateTime(): Start DateTime
- endDateTime(): End DateTime