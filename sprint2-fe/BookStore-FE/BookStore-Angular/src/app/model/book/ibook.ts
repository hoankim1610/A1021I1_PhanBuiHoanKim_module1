import {ICategory} from './icategory';
import {IAuthor} from './iauthor';
import {IPromotion} from './ipromotion';

export interface IBook {
  bookId?: number;
  bookName?: string;
  bookCode?: string;
  bookImage?: string;
  bookContent?: string;
  bookPrice?: number;
  bookTranslator?: string;
  bookTotalPage?: number;
  bookSize?: string;
  bookPublishDate?: string;
  bookQuantity?: number;
  bookPublisher?: string;
  bookCategoryId?: ICategory;
  bookAuthorId?: IAuthor;
  bookPromotionId?: IPromotion;
}
