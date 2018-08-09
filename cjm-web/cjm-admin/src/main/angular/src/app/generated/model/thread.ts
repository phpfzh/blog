import {Tag} from "./Tag";

export interface Thread {
  subject: string;
  dateline: string;
  views: string;
  threadData: string;
  fname: string;
  coverimg: string;
  content: string;
  replies: string;
  listtags:Tag;
  username:string;
  headurl:string;
}
