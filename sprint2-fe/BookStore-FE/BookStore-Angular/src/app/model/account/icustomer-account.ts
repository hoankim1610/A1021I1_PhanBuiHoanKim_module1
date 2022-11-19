import {ICustomer} from '../customer/icustomer';
import {IAccount} from './iaccount';

export interface ICustomerAccount {
  customer?: ICustomer;
  account?: IAccount;
}
