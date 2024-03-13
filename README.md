<<<<<<< HEAD
<<<<<<< HEAD
# Aplikasi Warung Makan Samudra

### Deskripsi

Setelah menyelesaikan pembelajaran tentang Restful API, Anda ditugaskan oleh manajemen Warung Makan Samudra (WMS) yang sedang berkembang pesat untuk menciptakan sebuah
API dengan fitur-fitur yang akan meningkatkan efisiensi dan kualitas layanan mereka.

Fitur-fitur yang diminta oleh manajemen WMS adalah:

1. Manajemen Cabang
2. Manajemen Produk/Menu
3. Manajemen Transaksi
4. Laporan Penjualan

### Cara Menjalankan Test:

1. Pastikan Anda telah menginstal Java Development Kit (JDK) `Minimal Versi 17` dan Maven di komputer Anda.
2. Buka terminal atau command prompt dan arahkan ke direktori proyek `Contoh: warung-makan-bahari-api`.
3. Jalankan perintah berikut untuk menjalankan semua tes:

```shell
mvn test -Dtest=TestSuite
```

### Catatan:

- Pastikan Anda telah melakukan konfigurasi yang tepat pada file `application.properties`.
- Jika test gagal silakan `truncate` semua table di database Anda.

## API Spec

### Branch API

#### Create Branch

Request :

- Method : POST
- Endpoint : `/api/branch`
- Header :
  - Content-Type: application/json
  - Accept: application/json
- Body :

```json 
{
  "branchCode": "string",
  "branchName": "string",
  "address": "string",
  "phoneNumber": "string"
}
```

Response :

```json 
{
  "errors": "string",
  "data": {
    "branchId": "string",
    "branchCode": "string",
    "branchName": "string",
    "address": "string",
    "phoneNumber": "string"
  },
  "paging": null
}
```

#### Get Product

Request :

- Method : GET
- Endpoint : `/api/branch/{id_branch}`
- Header :
  - Accept: application/json

Response :

```json 
{
  "errors": "string",
  "data": {
    "branchId": "string",
    "branchCode": "string",
    "branchName": "string",
    "address": "string",
    "phoneNumber": "string"
  },
  "paging": null
}
```

#### Update Branch

Request :

- Method : PUT
- Endpoint : `/api/branch`
- Header :
  - Content-Type: application/json
  - Accept: application/json
- Body :

```json 
{
  "branchId": "string",
  "branchCode": "string",
  "branchName": "string",
  "address": "string",
  "phoneNumber": "string"
}
```

Response :

```json 
{
  "errors": "string",
  "data": {
    "branchId": "string",
    "branchCode": "string",
    "branchName": "string",
    "address": "string",
    "phoneNumber": "string"
  },
  "paging": null
}
```

#### Delete Branch

Request :

- Method : DELETE
- Endpoint : `/api/branch/{id_branch}`
- Header :
  - Accept: application/json
- Body :

Response :

```json 
{
  "errors": "string",
  "data": "OK",
  "paging": null
}
```

### Product API

#### Create Product

Request :

- Method : POST
- Endpoint : `/api/products`
- Header :
  - Content-Type: application/json
  - Accept: application/json
- Body :

```json 
{
  "productCode": "string",
  "productName": "string",
  "price": "big decimal",
  "branchId": "string"
}
```

Response :

```json 
{
  "errors": "string",
  "data": {
    "productId": "string",
    "productPriceId": "string",
    "productCode": "string",
    "productName": "string",
    "price": "big decimal",
    "branch": {
      "branchId": "string",
      "branchCode": "string",
      "branchName": "string",
      "address": "string",
      "phoneNumber": "string"
    }
  },
  "paging": null
}
```

#### List Product

Request :

- Method : GET
- Endpoint : `/api/products`
- Header :
  - Accept: application/json
- Query Param :
  - size : number,
  - page : number,
  - productCode : string `optional`,
  - productName : string `optional`,
  - minPrice : string `optional`,
  - maxPrice : string `optional`,

Response :

```json 
{
  "errors": "string",
  "data": [
    {
      "productId": "string",
      "productPriceId": "string",
      "productCode": "string",
      "productName": "string",
      "price": "big decimal",
      "branch": {
        "branchId": "string",
        "branchCode": "string",
        "branchName": "string",
        "address": "string",
        "phoneNumber": "string"
      }
    },
    {
      "productId": "string",
      "productPriceId": "string",
      "productCode": "string",
      "productName": "string",
      "price": "big decimal",
      "branch": {
        "branchId": "string",
        "branchCode": "string",
        "branchName": "string",
        "address": "string",
        "phoneNumber": "string"
      }
    }
  ],
  "paging": {
    "count": "number",
    "totalPage": "number",
    "page": "number",
    "size": "number"
  }
}
```

#### List Product By Branch Id

Request :

- Method : GET
- Endpoint : `/api/products/{id_branch}`
- Header :
  - Accept: application/json

Response :

```json 
{
  "errors": "string",
  "data": [
    {
      "productId": "string",
      "productPriceId": "string",
      "productCode": "string",
      "productName": "string",
      "price": "big decimal",
      "branch": {
        "branchId": "string",
        "branchCode": "string",
        "branchName": "string",
        "address": "string",
        "phoneNumber": "string"
      }
    },
    {
      "productId": "string",
      "productPriceId": "string",
      "productCode": "string",
      "productName": "string",
      "price": "big decimal",
      "branch": {
        "branchId": "string",
        "branchCode": "string",
        "branchName": "string",
        "address": "string",
        "phoneNumber": "string"
      }
    }
  ],
  "paging": {
    "count": "number",
    "totalPage": "number",
    "page": "number",
    "size": "number"
  }
}
```

#### Update Product

Request :

- Method : PUT
- Endpoint : `/api/products`
- Header :
  - Content-Type: application/json
  - Accept: application/json
- Body :

```json 
{
  "productId": "string",
  "productCode": "string",
  "productName": "string",
  "price": "big decimal",
  "branchId": "string"
}
```

Response :

```json 
{
  "errors": "string",
  "data": {
    "productId": "string",
    "productPriceId": "string",
    "productCode": "string",
    "productName": "string",
    "price": "big decimal",
    "branch": {
      "branchId": "string",
      "branchCode": "string",
      "branchName": "string",
      "address": "string",
      "phoneNumber": "string"
    }
  },
  "paging": null
}
```

#### Delete Product

Request :

- Method : DELETE
- Endpoint : `/api/products/{id_product}`
- Header :
  - Accept: application/json
- Body :

Response :

```json 
{
  "errors": "string",
  "data": "OK",
  "paging": null
}
```

### Transaction API

#### Create Transaction

Request :

- Method : POST
- Endpoint : `/api/transactions`
- Header :
  - Content-Type: application/json
  - Accept: application/json
- Body :

Request :

Transaction Type :

- "1" : `EAT IN`
- "2" : `ONLINE`
- "3" : `TAKE AWAY`

```json
{
  "transactionType": "string",
  "billDetails": [
    {
      "productPriceId": "string",
      "quantity": "number"
    },
    {
      "productPriceId": "string",
      "quantity": "number"
    }
  ]
}
```

Response :

- Template Receipt Number : `{branchCode}-{year}-{sequenceNumber}`
- Transaction Type : `EAT_IN | TAKE_AWAY | ONLINE`

```json
{
  "errors": "string",
  "data": {
    "billId": "string",
    "receiptNumber": "string",
    "transDate": "string",
    "transactionType": "string",
    "billDetails": [
      {
        "billDetailId": "string",
        "billId": "string",
        "product": {
          "productId": "string",
          "productPriceId": "string",
          "productCode": "string",
          "productName": "string",
          "price": "bigDecimal",
          "branch": {
            "branchId": "string",
            "branchCode": "string",
            "branchName": "string",
            "address": "string",
            "phoneNumber": "string"
          }
        },
        "quantity": "number",
        "totalSales": "bigDecimal"
      }
    ]
  },
  "paging": null
}
```

#### Get Transaction

Request :

- Method : GET
- Endpoint : `/api/transactions/{id_bill}`
- Header :
  - Accept: application/json
- Body :

Response :

- Template Receipt Number : `{branchCode}-{year}-{sequenceNumber}`
- Transaction Type : `EAT_IN | TAKE_AWAY | ONLINE`

```json
{
  "errors": "string",
  "data": {
    "billId": "string",
    "receiptNumber": "string",
    "transDate": "localDateTime",
    "transactionType": "string",
    "billDetails": [
      {
        "billDetailId": "string",
        "billId": "string",
        "product": {
          "productId": "string",
          "productCode": "string",
          "productName": "string",
          "price": "bigDecimal",
          "branch": {
            "branchId": "string",
            "branchCode": "string",
            "branchName": "string",
            "address": "string",
            "phoneNumber": "string"
          }
        },
        "quantity": "number"
      }
    ]
  },
  "paging": null
}
```

#### List Transaction

Pattern string date : `dd-MM-yyyy`

Request :

- Method : GET
- Endpoint : `/api/transactions`
- Header :
  - Accept : application/json
- Query Param :
  - page : number
  - size : number
  - receiptNumber : string `optional`
  - startDate : string `optional`
  - endDate : string `optional`
  - transType : string `optional`
  - productName : string `optional`
- Body :

Response :

- Template Receipt Number : `{branchId}-{year}-{sequenceNumber}`
- Transaction Type : `EAT_IN | TAKE_AWAY | ONLINE`

```json
{
  "errors": "string",
  "data": [
    {
      "billId": "string",
      "receiptNumber": "string",
      "transDate": "localDateTime",
      "transactionType": "string",
      "billDetails": [
        {
          "billDetailId": "string",
          "billId": "string",
          "product": {
            "productId": "string",
            "productCode": "string",
            "productName": "string",
            "price": "bigDecimal",
            "branch": {
              "branchId": "string",
              "branchCode": "string",
              "branchName": "string",
              "address": "string",
              "phoneNumber": "string"
            }
          },
          "quantity": "number"
        }
      ]
    }
  ],
  "paging": null
}
```

#### Get Total Sales

Request :

Pattern string date : `dd-MM-yyyy`

- Method : GET
- Endpoint : `/api/transactions/total-sales`
- Header :
  - Accept: application/json
- Query Param :
  - startDate : string `optional`,
  - endDate : string `optional`,
- Body :

Response :

```json
{
  "errors": "string",
  "data": {
    "eatIn": "bigDecimal",
    "takeAway": "bigDecimal",
    "online": "bigDecimal"
  },
  "paging": null
}
```

=======
=======
>>>>>>> 31736e702bee24420adacce57e0913959ac436fc
# challenge-restful-api-java



## Getting started

To make it easy for you to get started with GitLab, here's a list of recommended next steps.

Already a pro? Just edit this README.md and make it your own. Want to make it easy? [Use the template at the bottom](#editing-this-readme)!

## Add your files

- [ ] [Create](https://docs.gitlab.com/ee/user/project/repository/web_editor.html#create-a-file) or [upload](https://docs.gitlab.com/ee/user/project/repository/web_editor.html#upload-a-file) files
- [ ] [Add files using the command line](https://docs.gitlab.com/ee/gitlab-basics/add-file.html#add-a-file-using-the-command-line) or push an existing Git repository with the following command:

```
cd existing_repo
git remote add origin https://git.enigmacamp.com/enigma-20/salsa-nadira-putri/challenge-restful-api-java.git
git branch -M master
git push -uf origin master
```

## Integrate with your tools

- [ ] [Set up project integrations](https://git.enigmacamp.com/enigma-20/salsa-nadira-putri/challenge-restful-api-java/-/settings/integrations)

## Collaborate with your team

- [ ] [Invite team members and collaborators](https://docs.gitlab.com/ee/user/project/members/)
- [ ] [Create a new merge request](https://docs.gitlab.com/ee/user/project/merge_requests/creating_merge_requests.html)
- [ ] [Automatically close issues from merge requests](https://docs.gitlab.com/ee/user/project/issues/managing_issues.html#closing-issues-automatically)
- [ ] [Enable merge request approvals](https://docs.gitlab.com/ee/user/project/merge_requests/approvals/)
- [ ] [Automatically merge when pipeline succeeds](https://docs.gitlab.com/ee/user/project/merge_requests/merge_when_pipeline_succeeds.html)

## Test and Deploy

Use the built-in continuous integration in GitLab.

- [ ] [Get started with GitLab CI/CD](https://docs.gitlab.com/ee/ci/quick_start/index.html)
- [ ] [Analyze your code for known vulnerabilities with Static Application Security Testing(SAST)](https://docs.gitlab.com/ee/user/application_security/sast/)
- [ ] [Deploy to Kubernetes, Amazon EC2, or Amazon ECS using Auto Deploy](https://docs.gitlab.com/ee/topics/autodevops/requirements.html)
- [ ] [Use pull-based deployments for improved Kubernetes management](https://docs.gitlab.com/ee/user/clusters/agent/)
- [ ] [Set up protected environments](https://docs.gitlab.com/ee/ci/environments/protected_environments.html)

***

# Editing this README

When you're ready to make this README your own, just edit this file and use the handy template below (or feel free to structure it however you want - this is just a starting point!). Thank you to [makeareadme.com](https://www.makeareadme.com/) for this template.

## Suggestions for a good README
Every project is different, so consider which of these sections apply to yours. The sections used in the template are suggestions for most open source projects. Also keep in mind that while a README can be too long and detailed, too long is better than too short. If you think your README is too long, consider utilizing another form of documentation rather than cutting out information.

## Name
Choose a self-explaining name for your project.

## Description
Let people know what your project can do specifically. Provide context and add a link to any reference visitors might be unfamiliar with. A list of Features or a Background subsection can also be added here. If there are alternatives to your project, this is a good place to list differentiating factors.

## Badges
On some READMEs, you may see small images that convey metadata, such as whether or not all the tests are passing for the project. You can use Shields to add some to your README. Many services also have instructions for adding a badge.

## Visuals
Depending on what you are making, it can be a good idea to include screenshots or even a video (you'll frequently see GIFs rather than actual videos). Tools like ttygif can help, but check out Asciinema for a more sophisticated method.

## Installation
Within a particular ecosystem, there may be a common way of installing things, such as using Yarn, NuGet, or Homebrew. However, consider the possibility that whoever is reading your README is a novice and would like more guidance. Listing specific steps helps remove ambiguity and gets people to using your project as quickly as possible. If it only runs in a specific context like a particular programming language version or operating system or has dependencies that have to be installed manually, also add a Requirements subsection.

## Usage
Use examples liberally, and show the expected output if you can. It's helpful to have inline the smallest example of usage that you can demonstrate, while providing links to more sophisticated examples if they are too long to reasonably include in the README.

## Support
Tell people where they can go to for help. It can be any combination of an issue tracker, a chat room, an email address, etc.

## Roadmap
If you have ideas for releases in the future, it is a good idea to list them in the README.

## Contributing
State if you are open to contributions and what your requirements are for accepting them.

For people who want to make changes to your project, it's helpful to have some documentation on how to get started. Perhaps there is a script that they should run or some environment variables that they need to set. Make these steps explicit. These instructions could also be useful to your future self.

You can also document commands to lint the code or run tests. These steps help to ensure high code quality and reduce the likelihood that the changes inadvertently break something. Having instructions for running tests is especially helpful if it requires external setup, such as starting a Selenium server for testing in a browser.

## Authors and acknowledgment
Show your appreciation to those who have contributed to the project.

## License
For open source projects, say how it is licensed.

## Project status
If you have run out of energy or time for your project, put a note at the top of the README saying that development has slowed down or stopped completely. Someone may choose to fork your project or volunteer to step in as a maintainer or owner, allowing your project to keep going. You can also make an explicit request for maintainers.
<<<<<<< HEAD
>>>>>>> 31736e702bee24420adacce57e0913959ac436fc
=======
>>>>>>> 31736e702bee24420adacce57e0913959ac436fc
