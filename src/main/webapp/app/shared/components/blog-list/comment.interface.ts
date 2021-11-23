import { User } from "app/admin/user-management/user-management.model";

export interface Comment {
    id?:number;
    user:User;
    content:string;
    blogId:number;
}