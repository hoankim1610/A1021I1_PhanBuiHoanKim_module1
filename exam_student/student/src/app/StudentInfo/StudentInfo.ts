import {IStudent} from "../Student/IStudent";

export class StudentInfo {
  static studentList: IStudent[] = [{
    avatar: 'https://previews.123rf.com/images/nikolaydzhi/nikolaydzhi1609/nikolaydzhi160900319/64778751-muslim-girl-avatar-arab-beautiful-woman-in-green-hijab-vector.jpg',
    id: 1,
    name: 'Maria',
    address: 'Afghanistan',
    phone: 987666644,
    email: 'maria10@gmail.com',
    mark: 8
  },
    {
      avatar: 'https://thumbs.dreamstime.com/z/girl-lovely-avatar-blonde-hair-cartoon-icon-stock-vector-93364827.jpg',
      id: 2,
      name: 'Lucia',
      address: 'America',
      phone: 975646473,
      email: 'lucia11@gmail.com',
      mark: 5
    },
  ];

  static getAll() {
    return this.studentList;
  }
}
