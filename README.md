# student1510

- test how to use
- master


```
git add . // Ҫadd���ļ���. ��ʾ�������
git commit -m 'add files' // �ύ����
git push origin master  // push��Զ��master��

```
test
# ��or create a new repository on the command line
```
 echo "# weizhang.github.io" >> README.md
 git init
 git add README.md
 git commit -m "first commit"
 git remote add origin git@github.com:nmww/weizhang.github.io.git
 git push -u origin master
```

# ��or push an existing repository from the command line
```
  git remote add origin git@github.com:nmww/weizhang.github.io.git
  git push -u origin master
```
# ��or import code from another repository
- You can initialize this repository with code from a Subversion, Mercurial, or TFS project.

# �ظ�����ʷ�汾

* https://blog.csdn.net/sinat_26367835/article/details/45047411
* https://blog.csdn.net/yxys01/article/details/78454315?locationnum=10&fps=1

```
1�� ������ʷ�汾

       ʹ��git log����鿴���е���ʷ�汾����ȡ��git��ĳ����ʷ�汾��id
       $ git log --pretty=oneline

       ����鵽��ʷ�汾��id��fae6966548e3ae76cfa7f38a461c438cf75ba965��

2�� �ָ�����ʷ�汾

$ git reset --hard fae6966548e3ae76cfa7f38a461c438cf75ba965
1
3�� ���޸��Ƶ�Զ�̷�����

$ git push -f -u origin master  
```