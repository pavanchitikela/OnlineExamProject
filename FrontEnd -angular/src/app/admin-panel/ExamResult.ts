import { Exam } from "./Exam";
import { ExamLevel } from "./ExamLevel";
import { ExamUser } from "./ExamUser";

export class ExamResult
{
    resultId!: number;
    exam!: Exam;
    examUser!: ExamUser;
    examLevel!: ExamLevel;
    crctAns!: number;
    incrctAns!: number;
    marks!: number; 
    percentage!: DoubleRange;
    status!: string;

}