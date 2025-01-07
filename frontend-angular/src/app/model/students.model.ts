export interface Student {
  id: string;
  firstName: string;
  lastName: string;
  code: string;
  programId: string;
  photo: string;
}

export interface Payment{
  id: number;
  date: string;
  amount: number;
  type: string;
  status: string;
  file: string;
  students: Student;
}

export enum PaymentType {
  CASH, CHECK, TRANSFER, DEPOSIT
}

export enum PaymentStatus {
  CREATED, VALIDATED, REJECTED
}
