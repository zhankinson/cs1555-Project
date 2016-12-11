# CS1555-Project
## The SCHEMAtics Repo
### Team Members
- Zach Hankinson
- Tim Kang

### To Run
- Run sqlplus from directory containing run.sql
- Type `@run.sql`
- Database will then be created and populated with proper triggers in place

- Open unix to where the java files are located
- Type `javac driver.java`
- Type `java driver`

assumptions:
- reservation tells when flight date occurs

to note:
- we would have included more data in our benchmark but we ran into "maximum open cursors exceed" exceptions
- cid and reservation id are created concurrently
